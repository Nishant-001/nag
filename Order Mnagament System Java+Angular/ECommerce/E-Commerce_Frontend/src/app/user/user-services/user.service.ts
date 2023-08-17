import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, of, tap } from 'rxjs';
import { UserStorageService } from 'src/app/services/storage/user-storage.service';
import { environment } from 'src/environments/environment';

const BASIC_URL = environment['BASIC_URL'];

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getProductsByTitle(title: any): Observable<any> {
    return this.http
      .get<[]>(BASIC_URL + `api/user/search/${title}`, {
        headers: this.createAuthorizationHeader(),
      })
      .pipe(
        tap((_) => this.log('Products fetched successfully')),
        catchError(this.handleError<[]>('Error getting Products', []))
      );
  }


  buyProduct(productId: any): Observable<any> {
    const orderDto = {
      productId: productId,
      userId: UserStorageService.getUserId(),
    }
    return this.http
      .post<[]>(BASIC_URL + `api/user/order-product`, orderDto, {
        headers: this.createAuthorizationHeader(),
      })
      .pipe(
        tap((_) => this.log('Order placed successfully')),
        catchError(this.handleError<[]>('Error placing Product', []))
      );
  }

  getMyOrders(): Observable<any> {
    const userId = UserStorageService.getUserId();
    return this.http
      .get<[]>(BASIC_URL + `api/user/myOrders/${userId}`, {
        headers: this.createAuthorizationHeader(),
      })
      .pipe(
        tap((_) => this.log('My Order fetched successfully')),
        catchError(this.handleError<[]>('Error getting My Orders', []))
      );
  }

  getAllProducts(): Observable<any> {
    return this.http
      .get<[]>(BASIC_URL + `api/user/products`, {
        headers: this.createAuthorizationHeader(),
      })
      .pipe(
        tap((_) => this.log('Products fetched successfully')),
        catchError(this.handleError<[]>('Error getting Products', []))
      );
  }

  createAuthorizationHeader(): HttpHeaders {
    let authHeaders: HttpHeaders = new HttpHeaders();
    return authHeaders.set(
      'Authorization',
      'Bearer ' + UserStorageService.getToken()
    );
  }

  log(message: string): void {
    console.log(`User Auth Service: ${message}`);
  }

  handleError<T>(operation = 'operation', result?: T): any {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
