import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from 'src/app/models/appointment';
import { Doctor } from 'src/app/models/doctor';
import { Slots } from 'src/app/models/slots';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-patientlist',
  templateUrl: './patientlist.component.html',
  styleUrls: ['./patientlist.component.css']
})
export class PatientlistComponent implements OnInit {

  currRole = '';
  loggedUser = '';
  patients : Observable<Appointment[]> | undefined;
  slots : Observable<Slots[]> | undefined;
  responses : Observable<any> | undefined;

  constructor(private _service : DoctorService) { }

  ngOnInit(): void
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    if(this.currRole === "user")
    {
      this.patients = this._service.getPatientListByDoctorEmail(this.loggedUser);
    }
    else
    {
      this.patients = this._service.getPatientList();
    }
    this.slots = this._service.getSlotDetails(this.loggedUser);
  }

  acceptRequest(slot : string)
  {
    this.responses = this._service.acceptRequestForPatientApproval(slot);
    $("#acceptbtn").hide();
    $("#rejectbtn").hide();
    $("#acceptedbtn").show();
    $("#rejectedbtn").hide();
  }

  rejectRequest(slot : string)
  {
    this.responses = this._service.rejectRequestForPatientApproval(slot);
    $("#acceptbtn").hide();
    $("#rejectbtn").hide();
    $("#acceptedbtn").hide();
    $("#rejectedbtn").show();
  }


}
