import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DepositarService {

  constructor(private http: HttpClient) { }
}
