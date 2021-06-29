import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Appointment } from 'src/app/models/appointment';
import { Prescription } from 'src/app/models/prescription';
import { DoctorService } from 'src/app/services/doctor.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-addprescription',
  templateUrl: './addprescription.component.html',
  styleUrls: ['./addprescription.component.css']
})
export class AddprescriptionComponent implements OnInit 
{
  currRole = '';
  loggedUser = '';
  message = '';
  prescriptionobj = new Prescription();
  appointment : Observable<Appointment[]> | undefined;

  constructor(private _service : DoctorService, private _router: Router, private userService : UserService) { }

  ngOnInit(): void 
  {
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

    this.appointment = this._service.getPatientList();
    $('#messagecard').hide();
  }

  addPrescription()
  {
    this._service.addPrescriptions(this.prescriptionobj).subscribe(
      data => {
        console.log("Prescriptions added Successfully");
        this.message = "Your prescription added successfully, Please check the patient's admission status!!!";
        $('#appointmentform').hide();
        $('#messagecard').show();
        setTimeout(() => {
          this._router.navigate(['/doctordashboard']);
        }, 5000);
      },
      error => {
        console.log("process Failed");
        this.message = "There is a problem in  YouAdding your prescription, Please try again !!!";
        $('#appointmentform').hide();
        $('#messagecard').show();
        console.log(error.error);
      }
    )
  }
}