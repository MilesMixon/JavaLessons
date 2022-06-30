import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OwnerListComponent } from './owner-list/owner-list.component';
import { FounderComponent } from './founder/founder.component';
import { NewOwnerComponent } from './new-owner/new-owner.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { OwnerDetailsComponent } from './owner-details/owner-details.component';
import { OwnerDetailsNavComponent } from './owner-details-nav/owner-details-nav.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';

//where you setup the components that make up your application
@NgModule({
  declarations: [
    AppComponent,
    OwnerListComponent,
    FounderComponent,
    NewOwnerComponent,
    OwnerDetailsComponent,
    OwnerDetailsNavComponent,
    NewVehicleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
