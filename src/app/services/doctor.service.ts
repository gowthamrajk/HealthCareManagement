import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Doctor } from '../models/doctor';
import { Prescription } from '../models/prescription';
import { Slots } from '../models/slots';
import { User } from '../models/user';

const NAV_URL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  user = new User();
  doctor = new Doctor();

  constructor(private _http : HttpClient) { }

  addDoctorFromRemote(doctor : Doctor) : Observable<any>
  {
      return this._http.post<any>(`${NAV_URL}/addDoctor`,doctor)
  }

  getDoctorList() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/doctorlist`);
  }

  getSlotList() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/slotDetails`);
  }

  getSlotListWithUniqueDoctors() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/slotDetailsWithUniqueDoctors`);
  }

  getSlotListWithUniqueSpecializations() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/slotDetailsWithUniqueSpecializations`);
  }

  getSlotDetails(loggedUser : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/slotDetails/`+loggedUser);
  }

  getDoctorListByEmail(loggedUser : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/doctorlistbyemail/`+loggedUser);
  }

  getPatientListByEmail(email : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/patientlistbyemail/`+email);
  }

  getPatientList() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/patientlist`);
  }

  getPatientListByDoctorEmail(loggedUser : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/patientlistbydoctoremail/`+loggedUser);
  }

  getPatientListByDoctorEmailAndDate(loggedUser : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/patientlistbydoctoremailanddate/`+loggedUser);
  }

  public acceptRequestForDoctorApproval(email : string) : Observable<any>
  {
    console.log("accepted");
    return this._http.get<any>(`${NAV_URL}/acceptstatus/`+email);
  }

  public rejectRequestForDoctorApproval(email : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/rejectstatus/`+email)
  }

  public acceptRequestForPatientApproval(slot : string) : Observable<any>
  {
    console.log("accepted");
    return this._http.get<any>(`${NAV_URL}/acceptpatient/`+slot);
  }

  public rejectRequestForPatientApproval(slot : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/rejectpatient/`+slot);
  }

  public addBookingSlots(slot : Slots) : Observable<any>
  {
    return this._http.post<any>(`${NAV_URL}/addBookingSlots`,slot);
  }

  public addPrescriptions(prescription : Prescription) : Observable<any>
  {
    return this._http.post<any>(`${NAV_URL}/addPrescription`,prescription)
  }

  public getProfileDetails(loggedUser : string) : Observable<any>
  {
    return this._http.get(`${NAV_URL}/doctorProfileDetails/`+loggedUser);
  }
  
  public UpdateDoctorProfile(user:any):Observable<any>
  {
    return this._http.put<any>(`${NAV_URL}/updatedoctor`,user)
  }

}
