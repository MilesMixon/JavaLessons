import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Owner } from '../models/owner.model';
import { OwnerService } from '../services/owner-service.service';

@Component({
  selector: 'app-owner-list',
  templateUrl: './owner-list.component.html',
  styleUrls: ['./owner-list.component.css']
})
export class OwnerListComponent implements OnInit {
  OwnerList: Owner[] = [];
  selectedOwner?: Owner;

  constructor(private ownerService: OwnerService, private router: Router) { }

  //called when this component is rendered
  ngOnInit(): void {
    //subscribe tells it to make the request
    this.ownerService.findAll().subscribe((data) => {
      //console.log("body: " + data.body);
      if (data.body != null) {
        this.OwnerList = data.body;
      }
    });
  }

  growTable() {
    // through data binding and changes to the OwnerList are automatically reflected on the UI
    let temp: Owner = new Owner(72, 'Dan Pickles the 4th', 'Cucumber', 'Orange', 7);

    this.OwnerList.push(temp);
    this.OwnerList.push(temp);
    this.OwnerList.push(temp);
  }

  shuffleTable() {
    this.OwnerList.reverse();
  }

  selectOwner(owner: Owner) {
    //this.selectedOwner = owner;
    //maybe we want it to navigate from here to the owner details component
    //and maybe it has to do a get request for the details
    let route = this.router.config.find(r => r.path === 'owner-details/:id');
    if (route) {
      route.data = owner;
      this.router.navigateByUrl(`/owner-details/${owner.id}`);
    }
  }
}
