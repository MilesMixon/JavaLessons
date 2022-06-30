import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, Validators } from '@angular/forms';
import { Vehicle } from '../models/vehicle.model';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.css']
})
export class NewVehicleComponent implements OnInit {
  //define a form group. inside the form group i tell it what fields I want,
  //their initial values, validation, and can nest form groups
  vehicleForm = this.fb.group({
    make: ['', Validators.compose([Validators.required, Validators.maxLength(45)])],
    model: ['', Validators.compose([Validators.required, Validators.maxLength(45)])],
    year: ['', Validators.compose([Validators.required, Validators.min(1950)])],
    color: ['', Validators.maxLength(25)],
    price: ['', Validators.max(1000000000.99)],
    parkingPermits: this.fb.array([
      this.fb.control('')
    ])
  });

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("We did it");
    console.log(this.vehicleForm);
    console.log(this.vehicleForm.value)
    let Temp = new Vehicle(0, this.make.value!, this.model.value!, parseInt(this.year.value!), this.color.value!, parseFloat(this.price.value!));
    console.log(Temp);
  }

  addPermits() {
    this.parkingPermits.push(this.fb.control(''));
  }

  //need to setup the ability to grab these values from the form
  // ? means it can be undefined
  // ! means it wont be null
  get make() {
    return this.vehicleForm.get('make')!;
  }

  get model() {
    return this.vehicleForm.get('model')!;
  }

  get year() {
    return this.vehicleForm.get('year')!;
  }

  get color() {
    return this.vehicleForm.get('color')!;
  }

  get price() {
    return this.vehicleForm.get('price')!;
  }

  get parkingPermits() {
    return this.vehicleForm.get('parkingPermits') as FormArray;
  }
}
