import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from './user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: Array<User>;

  addForm: FormGroup;

  constructor(
    private httpClient: HttpClient,
    private formBuilder: FormBuilder
  ) {
    this.users = [];
    this.addForm = this.formBuilder.group({});
  }

  ngOnInit(): void {
    this.initForm();
    this.getUserList();
  }

  initForm() {
    this.addForm = this.formBuilder.group({
      id: new FormControl(undefined, Validators.required),
      name: new FormControl(undefined, Validators.required),
      age: new FormControl(undefined, [Validators.required, Validators.max(100)]),
    });
  }
  getUserList() {
    this.httpClient.get<Array<User>>("http://127.0.0.1/user/list").subscribe((users) => {
      this.users = users;
    })
  }

  getId() {
    return this.addForm.controls['id'];
  }

  submitUserForm() {
    this.httpClient.post<Array<User>>("http://127.0.0.1/user/add", this.addForm.value).subscribe((response) => {
      this.getUserList();
    })
  }
}
