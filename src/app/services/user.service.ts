import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Appointment } from '../models/appointment';

const NAV_URL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http : HttpClient) { }

  getAllUsers() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/userlist`);
  }

  addBookingAppointments(appointment : Appointment) : Observable<any>
  {
    return this._http.post<any>(`${NAV_URL}/bookNewAppointment`,appointment);
  }

  getPrescriptionsByName(name : string) : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/getprescriptionbyname/`+name);
  }

  public getProfileDetails(loggedUser : string) : Observable<any>
  {
    return this._http.get(`${NAV_URL}/profileDetails/`+loggedUser);
  }
  
  public UpdateUserProfile(user:any):Observable<any>
  {
    return this._http.put<any>(`${NAV_URL}/updateuser`,user);
  }

  public getTotalPatients() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotalpatients`);
  }

  public getTotalUsers() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotalusers`);
  }

  public getTotalDoctors() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotaldoctors`);
  }

  public getTotalSlots() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotalslots`);
  }

  public getTotalAppointments() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotalappointments`);
  }

  public getTotalPrescriptions() : Observable<any>
  {
    return this._http.get<any>(`${NAV_URL}/gettotalprescriptions`);
  }


}
