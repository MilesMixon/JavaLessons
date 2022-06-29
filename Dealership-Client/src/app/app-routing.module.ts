import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FounderComponent } from './founder/founder.component';
import { NewOwnerComponent } from './new-owner/new-owner.component';
import { OwnerDetailsNavComponent } from './owner-details-nav/owner-details-nav.component';
import { OwnerDetailsComponent } from './owner-details/owner-details.component';
import { OwnerListComponent } from './owner-list/owner-list.component';

//where you setup the routes for your "router-outlet", so it knows where to go
const routes: Routes = [
  {
    path: 'owners', component: OwnerListComponent
  },
  {
    path: 'founder', component: FounderComponent
  },
  {
    path: 'new-owner', component: NewOwnerComponent
  },
  {
    path: 'owner-details/:id', component: OwnerDetailsNavComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
