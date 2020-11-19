import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-simple-http',
  templateUrl: './simple-http.component.html',
  styleUrls: ['./simple-http.component.css']
})
export class SimpleHttpComponent implements OnInit {

  data: any;
  loading = false;
  errorMessage: string;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  doGet(): void {
    this.loading = true;
    this.errorMessage = '';

    this.http.get('https://jsonplaceholder.typicode.com/posts')
      .subscribe(data => {
        this.data = data;
        this.loading = false;
      }, error => {
        this.loading = false;
        this.errorMessage = error.message;
      });
  }

  clear(): void {
    this.errorMessage = '';
    this.data = null;
  }
}
