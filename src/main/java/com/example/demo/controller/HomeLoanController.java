package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.LoanAccount;
import com.example.demo.model.User;

@Controller
public class HomeLoanController {
	private static final User Null = null;

	@Autowired
	JdbcTemplate jdbctemplate;
	
	SimpleJdbcCall simpleJdbcCall;
	User userAccount;
	LoanAccount userLoanAccount;
	
	private final String DB_NAME = "homeloan";
	private final String ADD_LOAN_ACC = "add_lone_acc";
	private final String FORECLOSE_LOAN = "add_lone_acc";
	private final String PREPAY_LOAN= "get_all_students";
	
	@RequestMapping("home")
	public String home() {
		if(userAccount==Null)
			return "UserLogin.jsp";
		
		return "home.jsp";
	}
	@RequestMapping("/")
	public String login() {
		if(userAccount==Null)
		return "UserLogin.jsp";
		
		return "home.jsp";
	}
	@PostMapping("validate")
	public String validateUser(User user) {
		
		String sql="Select * from user where login_id=? and passwd=?";
		int result=jdbctemplate.queryForList(sql, user.getLogId(),user.getPassword()).size();
		if(result == 1)
		{
			userAccount=user;
			return "redirect:home";
		}
		else
		return "redirect:/";
	}
	@GetMapping("apply")
	public String apply() {
		if(userAccount==Null)
			return "UserLogin.jsp";
		return "ApplyLoan.jsp";
	}
	@GetMapping("prepay")
	public String prepay() {
		if(userAccount==Null)
			return "UserLogin.jsp";
		return "PrePayLoan.jsp";
	}
	@GetMapping("foreclose")
	public String foreclose() {
		if(userAccount==Null)
			return "UserLogin.jsp";
		return "ForeCloseLoan.jsp";
	}
	
	
	@PostMapping("applyLoan")
	public String applyLoan(LoanAccount loanaccount, @RequestParam("image") MultipartFile multipartFile) {
		if(userAccount==Null)
			return "UserLogin.jsp";
		
		//if(loanaccount.getTotal_loan_amt() <= 50*loanaccount.getNet_month_sal() && loanaccount.getTotal_loan_amt()>0 && loanaccount.getTenure()>=5 && loanaccount.getTenure()<=20) {
			try {
				simpleJdbcCall= new SimpleJdbcCall(jdbctemplate.getDataSource());
				simpleJdbcCall.withCatalogName(DB_NAME);
				// procedure name
				simpleJdbcCall.withProcedureName(ADD_LOAN_ACC);
				simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
				simpleJdbcCall.declareParameters(new SqlParameter("in_savings_acc_no", Types.BIGINT),
						new SqlParameter("in_tot_loan_amt", Types.INTEGER),
						new SqlParameter("in_tenure", Types.INTEGER),
						new SqlParameter("in_addr", Types.VARCHAR),
						new SqlParameter("in_net_mnth_sal", Types.INTEGER),
						new SqlParameter("in_photo",Types.BLOB),
						new SqlOutParameter("out_result", Types.INTEGER));
				// put in parameter value in Map
				Map<String, Object> map = new HashMap<String, Object>();
				loanaccount.setSaving_acc_no(userAccount.getLogId());
				map.put("in_savings_acc_no", loanaccount.getSaving_acc_no());
				map.put("in_tot_loan_amt", loanaccount.getTotal_loan_amt());
				map.put("in_tenure", loanaccount.getTenure());
				map.put("in_addr", loanaccount.getAddress());
				map.put("in_net_mnth_sal", loanaccount.getNet_month_sal());
				
				String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				loanaccount.setAssetImage(fileName);
				final File image = new File(fileName);
			   final InputStream imageIs = new FileInputStream(image);   
			   LobHandler lobHandler = new DefaultLobHandler(); 
			   map.put("in_photo",new SqlLobValue(imageIs, (int)image.length(), lobHandler));
			   
			   Map<String, Object> result = simpleJdbcCall.execute(map);
				
				if (Integer.parseInt((String) result.get("out_result"))==1)
				{
					userLoanAccount=loanaccount;
					return "ApplyLoan.jsp";
				}
					
				
		} catch (DataAccessException e) {
			   System.out.println("DataAccessException " + e.getMessage());
			  } catch (FileNotFoundException e) {
			   System.out.println("DataAccessException " + e.getMessage());
			  }
		//}
		return "ApplyLoan.jsp";
	}
	
	
	@GetMapping("repay")
	@PostMapping("repaySchedule")
	public String repaySchedule() {
		if(userAccount==Null)
			return "UserLogin.jsp";
		return "RepaySchedule.jsp";
	}
	
	
	@RequestMapping("prepayLoan")
	public String prepayLoan(Integer acc_id,Long amount) {
		if(userAccount==Null)
			return "UserLogin.jsp";
		try {
			simpleJdbcCall= new SimpleJdbcCall(jdbctemplate.getDataSource());
			simpleJdbcCall.withCatalogName(DB_NAME);
			// procedure name
			simpleJdbcCall.withProcedureName(PREPAY_LOAN);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.declareParameters(new SqlParameter("in_acc_id", Types.INTEGER),
					new SqlParameter("in_emi", Types.DECIMAL),
					new SqlOutParameter("out_result", Types.INTEGER));
			// put in parameter value in Map
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("in_acc_id", acc_id);
			map.put("in_emi", amount);
		   Map<String, Object> result = simpleJdbcCall.execute(map);
			
			if (Integer.parseInt((String) result.get("out_result"))==1)
				return "PrePayLoan.jsp";
			
	} catch (DataAccessException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  }
		return "PrePayLoan.jsp";
	}
	
	
	@RequestMapping("forecloseLoan")
	public String forecloseLoan(Integer acc_id) {
		if(userAccount==Null)
			return "UserLogin.jsp";
		try {
			simpleJdbcCall= new SimpleJdbcCall(jdbctemplate.getDataSource());
			simpleJdbcCall.withCatalogName(DB_NAME);
			// procedure name
			simpleJdbcCall.withProcedureName(FORECLOSE_LOAN);
			simpleJdbcCall.withoutProcedureColumnMetaDataAccess();
			simpleJdbcCall.declareParameters(new SqlParameter("in_acc_id", Types.INTEGER),
					new SqlOutParameter("out_result", Types.INTEGER));
			// put in parameter value in Map
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("in_acc_id", acc_id);
		   
		   Map<String, Object> result = simpleJdbcCall.execute(map);
			
			if (Integer.parseInt((String) result.get("out_result"))==1)
				return "ForeCloseLoan.jsp";
			
	} catch (DataAccessException e) {
		   System.out.println("DataAccessException " + e.getMessage());
		  }
		return "ForeCloseLoan.jsp";
	}
	
}
