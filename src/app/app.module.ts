import { NgModule } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { RegistrationsuccessComponent } from './components/registrationsuccess/registrationsuccess.component';
import { UserdashboardComponent } from './components/userdashboard/userdashboard.component';
import { AdmindashboardComponent } from './components/admindashboard/admindashboard.component';
import { DoctordashboardComponent } from './components/doctordashboard/doctordashboard.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { AddingdoctorComponent } from './components/addingdoctor/addingdoctor.component';
import { DoctorlistComponent } from './components/doctorlist/doctorlist.component';
import { UserlistComponent } from './components/userlist/userlist.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { DoctorprofileComponent } from './components/doctorprofile/doctorprofile.component';
import { PatientlistComponent } from './components/patientlist/patientlist.component';
import { ApprovedoctorsComponent } from './components/approvedoctors/approvedoctors.component';
import { BookappointmentComponent } from './components/bookappointment/bookappointment.component';
import { ScheduleslotsComponent } from './components/scheduleslots/scheduleslots.component';
import { ApprovalstatusComponent } from './components/approvalstatus/approvalstatus.component';
import { CheckslotsComponent } from './components/checkslots/checkslots.component';
import { AddprescriptionComponent } from './components/addprescription/addprescription.component';
import { PrescriptionlistComponent } from './components/prescriptionlist/prescriptionlist.component';
import { WelcomepageComponent } from './components/welcomepage/welcomepage.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    RegistrationsuccessComponent,
    UserdashboardComponent,
    AdmindashboardComponent,
    DoctordashboardComponent,
    FooterComponent,
    HeaderComponent,
    AddingdoctorComponent,
    DoctorlistComponent,
    UserlistComponent,
    AppointmentsComponent,
    UserprofileComponent,
    DoctorprofileComponent,
    PatientlistComponent,
    ApprovedoctorsComponent,
    BookappointmentComponent,
    ScheduleslotsComponent,
    ApprovalstatusComponent,
    CheckslotsComponent,
    AddprescriptionComponent,
    PrescriptionlistComponent,
    WelcomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent, RegistrationComponent]
})
export class AppModule { }
