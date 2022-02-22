package com.trainingdemo.portlet;

import com.trainingdemo.constants.TrainingDemo1PortletKeys;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sudha
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TrainingDemo1",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TrainingDemo1PortletKeys.TRAININGDEMO1,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TrainingDemo1Portlet extends MVCPortlet {
	
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("We are in init method");
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		System.out.println("We are in render method");
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		System.out.println("We are in process Action");
		super.processAction(actionRequest, actionResponse);
	}
	
	public void submitform(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("We are in submitform method");
		String fname= ParamUtil.getString(actionRequest,"fname");
		String mname= ParamUtil.getString(actionRequest,"mname");
		String lname= ParamUtil.getString(actionRequest,"lname");
		String email= ParamUtil.getString(actionRequest,"email");
		String mobileno=ParamUtil.getString(actionRequest,"mobileno");
		String password=ParamUtil.getString(actionRequest,"password");
		String hobbies=ParamUtil.getString(actionRequest,"Hobbies");
		String date=ParamUtil.getString(actionRequest,"date");
		int age=0;
		System.out.println("Name "+fname);
		System.out.println("Middle name "+mname);
		System.out.println("Last name "+lname);
		System.out.println("email "+email);
		System.out.println("Mobile no "+mobileno);
		System.out.println("date "+date);
		System.out.println("Password "+password);
		System.out.println("Hobbies "+hobbies);

		
		String[] arrOfStr = email.split("@");
		String str=arrOfStr[1];
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		 Pattern p = Pattern.compile(regex);
		 
		 
		 

		  //convert String to LocalDate
		  LocalDate localDate = LocalDate.parse(date);
		 
		 Matcher m = p.matcher(password);
		 LocalDate today = LocalDate.now();
		 age=Period.between(localDate, today).getYears();	
		 System.out.println("Age is "+age);
  	    
		if(str.compareTo("lntinfotech.com")!=0) {
			SessionErrors.add(actionRequest,"email");
		}else if(mobileno.length()!=10) {
			SessionErrors.add(actionRequest,"mobile");
		}else if(m.matches()==false) {
			
			SessionErrors.add(actionRequest,"password");
		}else {
			SessionMessages.add(actionRequest,"success");
		}
	}
}