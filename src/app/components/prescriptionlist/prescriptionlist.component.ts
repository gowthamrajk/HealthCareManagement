import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Prescription } from 'src/app/models/prescription';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-prescriptionlist',
  templateUrl: './prescriptionlist.component.html',
  styleUrls: ['./prescriptionlist.component.css']
})
export class PrescriptionlistComponent implements OnInit {

  prescriptionlist : Observable<Prescription[]> | undefined;
  name : string = '';

  constructor(private _service : UserService) { }

  ngOnInit(): void 
  {
    
    $('#messagecard').show();
    $('#prescriptionpages').hide();

  }

  searchPrescription()
  {
    this.prescriptionlist = this._service.getPrescriptionsByName(this.name);
    $('#messagecard').hide();
    $('#prescriptionpages').show();
  }

  onPrint()
  {
    $("#printbtn").hide();
    $("#prescriptionpages").css('margin-top','6%');
    window.print();
  }

}
