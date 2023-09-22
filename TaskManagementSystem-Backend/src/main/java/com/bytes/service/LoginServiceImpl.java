//package com.bytes.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import com.bytes.repo.LoginRepository;
//import com.bytes.utils.Login;
//
//@Service
//public class LoginServiceImpl implements LoginService {
//	@Autowired
//	LoginRepository loginRepository;
//
//	@Override
//
//	public ResponseEntity<Login> loginDetails(Login login) {
//		System.out.println("checkk");
//		System.out.println(login.getEmail());
//		System.out.println(login.getPassword());
//		System.out.println(login.getRoleName());
//		if (login.getEmail().equals("shwethaknr@gmail.com") && login.getPassword().equals("admin123")) {
//			Login adminLogin = new Login();
//			adminLogin.setRoleName("superadmin"); 
//			return ResponseEntity.ok(adminLogin);
//		} else {
//			Login details = loginRepository.findByEmail(login.getEmail());
//			if (details.getEmail().equals(login.getEmail()) && details.getPassword().equals(login.getPassword())) {
//				String role = details.getRoleName();
//				if (role.equals("Admin") || role.equals("User")) {
//					return ResponseEntity.ok(details);
//				}
//			}
//			return ResponseEntity.ok(login);
//
//		}
//	}
//}
////	
////	  @Override
////	    public Login loginDetails(Login login) {
////	        System.out.println("checkk");
////	        System.out.println(login.getEmail());
////	        System.out.println(login.getPassword());
////	        System.out.println(login.getRoleName());
////	        
////	        if (login.getEmail().equals("shwethaknr@gmail.com") && login.getPassword().equals("admin123")) {
////	            Login adminLogin = new Login();
////	            adminLogin.setRoleName("superadmin");
////	            return adminLogin;
////	        } else {
////	            Login details = loginRepository.findByEmail(login.getEmail());
////	            if (details != null && details.getEmail().equals(login.getEmail()) && details.getPassword().equals(login.getPassword())) {
////	                String role = details.getRoleName();
////	                if (role.equals("Admin") || role.equals("User")) {
////	                    return details;
////	                }
////	            }
////	            return details;
////	        }
////	    }
////	}
