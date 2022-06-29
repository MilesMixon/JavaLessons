import { Component, Input, OnInit } from '@angular/core';
import { Owner } from '../models/owner.model';

@Component({
  selector: 'app-owner-details',
  templateUrl: './owner-details.component.html',
  styleUrls: ['./owner-details.component.css']
})
export class OwnerDetailsComponent implements OnInit {
  //angular components can also have properties
  //these are input to the compoent
  @Input() owner?: Owner;

  constructor() { }

  ngOnInit(): void {
  }

}
