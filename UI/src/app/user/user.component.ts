import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from './user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: Array<User>;

  id: number | undefined;
  name: string;
  age: number | undefined;

  constructor(
    private httpClient: HttpClient
  ) {
    this.users = [];
    this.id = undefined;
    this.name = '';
    this.age = undefined;
  }

  ngOnInit(): void {
    this.getUserList();
  }

  
  getUserList() {
    this.httpClient.get<Array<User>>("http://127.0.0.1/user/list").subscribe((users) => {
      this.users = users;
    })
  }

  addUser() {
    console.log(this.id)
    console.log(this.name)
    console.log(this.age)
    let body = {
      "id": this.id,
      "name": this.name,
      "age": this.age
    }

    this.httpClient.post<Array<User>>("http://127.0.0.1/user/add", body).subscribe((response) => {
      this.getUserList();
    })
  }
}
