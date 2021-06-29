import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from 'src/app/models/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-approvedoctors',
  templateUrl: './approvedoctors.component.html',
  styleUrls: ['./approvedoctors.component.css']
})
export class ApprovedoctorsComponent implements OnInit {

  currRole = '';
  loggedUser = '';
  doctors : Observable<Doctor[]> | undefined;
  responses : Observable<any> | undefined;
  
  constructor(private _service : DoctorService) { }

  ngOnInit(): void
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    this.doctors = this._service.getDoctorList();

  }

  acceptRequest(curremail : string)
  {
    this.responses = this._service.acceptRequestForDoctorApproval(curremail);
    $("#acceptbtn").hide();
    $("#rejectbtn").hide();
    $("#acceptedbtn").show();
    $("#rejectedbtn").hide();
  }

  rejectRequest(curremail : string)
  {
    this.responses = this._service.rejectRequestForDoctorApproval(curremail);
    $("#acceptbtn").hide();
    $("#rejectbtn").hide();
    $("#acceptedbtn").hide();
    $("#rejectedbtn").show();
  }

}
