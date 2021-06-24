import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders, HttpRequest} from '@angular/common/http';

@Component({
  selector: 'app-more-http-requests',
  templateUrl: './more-http-requests.component.html',
  styleUrls: ['./more-http-requests.component.scss']
})
export class MoreHttpRequestsComponent implements OnInit {

  data: any;
  loading: boolean;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  makePost(): void {
    this.loading = true;
    this.http
      .post(
        'https://jsonplaceholder.typicode.com/posts',
        JSON.stringify({
          body: 'bar',
          title: 'foo',
          userId: 1
        })
      )
      .subscribe(data => {
        this.data = data;
        this.loading = false;
      }, error => {
        this.loading = false;
        console.log(error);
      });
  }

  makeDelete(): void {
    this.loading = true;
    this.http
      .delete('https://jsonplaceholder.typicode.com/posts/1')
      .subscribe(data => {
        this.data = data;
        this.loading = false;
      }, error => {
        this.loading = false;
        console.log(error);
      });
  }

  makeHeaders(): void {
    this.loading = true;

    const headers: HttpHeaders = new HttpHeaders({
      'X-API-TOKEN': 'ng-book'
    });

    const req = new HttpRequest(
      'GET',
      'https://jsonplaceholder.typicode.com/posts/1',
      {
        headers
      }
    );

    this.http.request(req).subscribe(data => {
      this.loading = false;
      this.data = data['body'];
    }, error => {
      this.loading = false;
      console.log(error);
    });
  }
}
