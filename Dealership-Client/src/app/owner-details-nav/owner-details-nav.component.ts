import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Owner } from '../models/owner.model';
import { OwnerService } from '../services/owner-service.service';

@Component({
  selector: 'app-owner-details-nav',
  templateUrl: './owner-details-nav.component.html',
  styleUrls: ['./owner-details-nav.component.css']
})
export class OwnerDetailsNavComponent implements OnInit {
  owner: Owner = new Owner(0, "None", "None", "None", 0);
  ownerId: any;

  // use this to grab the active route and get the information from it
  constructor(private activeRoute: ActivatedRoute, private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.activeRoute.data.subscribe(result => {
      this.ownerId = result;
      this.ownerService.find(this.ownerId).subscribe(data => {
        if (data.body != null) {
          this.owner = data.body;
        }
      });
    })
  }

}
