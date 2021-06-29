import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Doctor } from '../models/doctor';
import { User } from '../models/user';
import { map } from "rxjs/operators";

const NAV_URL = environment.apiURL;

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  user = new User();
  doctor = new Doctor();

  constructor(private _http : HttpClient) { }

public registerUserFromRemote(user : User):Observable<any>
{
    return this._http.post<any>(`${NAV_URL}/registeruser`,user)
}

public registerDoctorFromRemote(doctor : Doctor):Observable<any>
{
    return this._http.post<any>(`${NAV_URL}/registerdoctor`,doctor)
}

}
