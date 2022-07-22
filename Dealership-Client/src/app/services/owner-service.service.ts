import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../models/owner.model';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
  //url: string = "http://localhost:8080/servlet-example/api/owners";
  url: string = "http://localhost:4631/owners/v1";

  //angualr comes with http functionality
  // injects in this HttpCLient for me
  // everything injected is a singleton
  constructor(private http: HttpClient) { }

  //Observables allow data binding to work
  //you observe and object and update to replect any changes to it
  findAll(): Observable<HttpResponse<Owner[]>> {
    return this.http.get<Owner[]>(this.url, { observe: 'response' });
  }

  find(id: number): Observable<HttpResponse<Owner>> {
    //console.log(ownerId);
    //return this.http.get<Owner>(this.url + `?id=${id}`, { observe: 'response' });
    return this.http.get<Owner>(this.url + `/${id}`, { observe: 'response' });
  }

  save(owner: Owner): Observable<HttpResponse<Owner>> {
    return this.http.post<Owner>(this.url, owner, { observe: 'response' });
  }
}
