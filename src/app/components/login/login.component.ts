import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();
  doctor = new Doctor();
  msg = "";
  adminEmail = "";
  adminPassword = "";

  constructor(private _service : LoginService, private _router : Router) { }

  ngOnInit(): void 
  {
    $(".admin-login-form").hide();
    $(".doctor-login-form").hide();
    $("#userbtn").css("border", "0");
    $("#doctorbtn").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("border-left", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");;
    $("#adminbtn").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");

    $(".userlogin").click(function(){
      $(".user-login-form").hide();
      $(".admin-login-form").show();
    });

    $("#userbtn").click(function(){
      $(".user-login-form").show();
      $(".admin-login-form").hide();
      $(".doctor-login-form").hide();
      $("#userbtn").css("border", "0").css("opacity", "1");
      $("#adminbtn").css("border", "0").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "1").css("opacity", "0.3");
      $("#doctorbtn").css("border", "0").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("border-left", "1.5px solid rgb(6, 50, 53)").css("opacity", "1").css("opacity", "0.3");
    });

    $("#doctorbtn").click(function(){
      $(".user-login-form").hide();
      $(".admin-login-form").hide();
      $(".doctor-login-form").show();
      $("#userbtn").css("border", "0").css("border-right", "1.5px solid rgb(6, 50, 53)").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");
      $("#adminbtn").css("border", "0").css("border-left", "1.5px solid rgb(6, 50, 53)").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");
      $("#doctorbtn").css("border", "0").css("opacity", "1");
    });

    $("#adminbtn").click(function(){
      $(".user-login-form").hide();
      $(".admin-login-form").show();
      $(".doctor-login-form").hide();
      $("#userbtn").css("border", "0").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");
      $("#adminbtn").css("border", "0").css("opacity", "1");
      $("#doctorbtn").css("border", "0").css("border-right", "1.5px solid rgb(6, 50, 53)").css("border-bottom", "1.5px solid rgb(6, 50, 53)").css("opacity", "0.3");;
    });
    
    $(".adminlogin").click(function(){
      $(".user-login-form").show();
      $(".admin-login-form").hide();
    });
  }

  loginUser()
  {
      this._service.loginUserFromRemote(this.user).subscribe(
        (data: any) => {
          console.log(data);
          console.log("Response Received");
          sessionStorage.setItem('loggedUser', this.user.email);
          sessionStorage.setItem('USER', "user");
          sessionStorage.setItem('ROLE', "user");
          sessionStorage.setItem('name', this.user.email);
          sessionStorage.setItem('gender', "male");
          this._router.navigate(['/userdashboard']);
        },
        (error: { error: any; }) => {
          console.log(error.error);
          this.msg="Bad credentials, please enter valid credentials !!!";
        }
      )
  }

  loginDoctor()
  {
      this._service.loginDoctorFromRemote(this.doctor).subscribe(
        (data: any) => {
          console.log(data);
          console.log("Response Received");
          sessionStorage.clear();
          sessionStorage.setItem('loggedUser', this.doctor.email);
          sessionStorage.setItem('USER', "doctor");
          sessionStorage.setItem('ROLE', "doctor");
          sessionStorage.setItem('doctorname',this.doctor.email);
          sessionStorage.setItem('gender', "male");
          this._router.navigate(['/doctordashboard']);
        },
        (error: { error: any; }) => {
          console.log(error.error);
          this.msg="Bad credentials, please enter valid credentials !!!";
        }
      )
  }

  adminLogin()
  {
    if(this._service.adminLoginFromRemote(this.adminEmail, this.adminPassword)) 
    {
      sessionStorage.setItem('loggedUser', this.adminEmail);
      sessionStorage.setItem('USER', "admin");
      sessionStorage.setItem('ROLE', "admin");
      sessionStorage.setItem('name', "admin");
      sessionStorage.setItem('gender', "male");
      this._router.navigate(['/admindashboard']);
    }
    else 
    {
      console.log("Exception Occured");
      this.msg = 'Bad admin credentials !!!'
    }
  }

}
