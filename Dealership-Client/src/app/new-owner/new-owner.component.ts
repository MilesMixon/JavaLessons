import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Owner } from '../models/owner.model';
import { OwnerService } from '../services/owner-service.service';

@Component({
  selector: 'app-new-owner',
  templateUrl: './new-owner.component.html',
  styleUrls: ['./new-owner.component.css']
})
export class NewOwnerComponent implements OnInit {
  //newOwner?: Owner; //? tells TS that the value can be undefined
  newOwner: Owner = new Owner (0, "Default", "Value", "Here", 0); 

  constructor(private ownerService: OwnerService, private router: Router) { }

  ngOnInit(): void {
  }

  create(): void {
    //send the forms values
    this.ownerService.save(this.newOwner).subscribe(data => {
      let route = this.router.config.find(r => r.path === 'owners');
      if (route) {
        this.router.navigateByUrl('/owners');
      }
    });
  }
}
