import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {

  isShowHomeComponent = true;

  constructor(
    private httpClient: HttpClient
  ) {
    console.log("constructor")
  }

  ngOnInit(): void {

    setTimeout(() => {
      this.isShowHomeComponent = false
    }, 5 * 1000);
    console.log("ngOnInit")
  }

  ngOnDestroy(): void {
    console.log("ngOnDestroy")
  }
}
