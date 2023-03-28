import { Component, OnDestroy } from '@angular/core';

@Component({
  selector: 'nigam',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnDestroy {
  ngOnDestroy(): void {
    console.log("HomeComponent >>ngOnDestroy")
  }


}
