import { Injectable } from '@angular/core';
import {Observable, Subject} from "rxjs";
import {Product} from "../model/product";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  notificationProduct: Subject<Product> = new Subject<Product>();

  constructor(private http: HttpClient) { }

  list(): Observable<Product[]> {
    return this.http.get<Product[]>(`${environment.api}/list`);
  }

  create(product: Product): Observable<Product> {
    return this.http.post<Product>(
      `${environment.api}/create`,
      JSON.stringify(product),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    );
  }

  delete(product: Product): Observable<Product> {
    return this.http.delete<Product>(`${environment.api}/delete/${product.id}`);
  }

  read(id: string): Observable<Product> {
    return this.http.get<Product>(`${environment.api}/read/${id}`);
  }

  update(product: Product): Observable<Product> {
    return this.http.put<Product>(
      `${environment.api}/update`,
      JSON.stringify(product),
      {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    );
  }

  notify(product: Product): void {
    this.notificationProduct.next(product);
  }
}

export const productServiceInjectables: Array<any> = [
  ProductService
];
