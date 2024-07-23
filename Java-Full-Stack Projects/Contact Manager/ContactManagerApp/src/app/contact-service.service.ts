import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { login } from './login';
import { Observable } from 'rxjs';
import { User } from './user';
import { Contact} from './contact';

@Injectable({
  providedIn: 'root',
})
export class ContactServiceService {
  constructor(private http: HttpClient) {}

  dologin(login: login): Observable<any> {
    return this.http.post('http://localhost:8080/login', login, {
      responseType: 'text' as 'json',
      withCredentials: true,
    });
  }

  dosignUp(user: User): Observable<any> {
    return this.http.post('http://localhost:8080/signup', user, {
      responseType: 'text' as 'json',
      withCredentials: true,
    });
  }

  viewContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>('http://localhost:8080/getcontact');
  }
}
