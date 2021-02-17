import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estado } from '../model/Estado';
import { Mensaje } from '../model/Mensaje';
import { Poliza } from '../model/Poliza';
import { Transferencia } from '../model/Transferencia';
import { Usuario } from '../model/Usuario';

@Injectable({
  providedIn: 'root'
})
export class DepositarService {
  //cambiar datos de envio de logeo
  private WS_LISTA_POLISA: string = "http://localhost:8080/Analisis/ws/transacciones/listarPoliza";
  private WS_LLISTAR_CUENTA: string = "http://localhost:8080/Analisis/ws/transacciones/listarEstado";
  private WS_TRANSFERENSIA: string = "http://localhost:8080/Analisis/ws/transacciones/transferencia";
  private WS_CAMBIO_CLAVE: string = "http://localhost:8080/Analisis/ws/transacciones/recuperar";
  private WS_LOGEO: string ="http://localhost:8080/Analisis/ws/transacciones/logeo"
  constructor(private http: HttpClient) { }
  listarPoliza(): Observable<any> {
    return this.http.get<Poliza[]>(this.WS_LISTA_POLISA +"?clave=1");
  }
  listarcuenta(): Observable<any> {
    return this.http.get<Estado[]>(this.WS_LLISTAR_CUENTA +"?clave='1'");
  }
  trasferencia(transferensia: Transferencia): Observable<any> {
    console.log("transaccion completa", transferensia);
    return this.http.post<Mensaje>(this.WS_TRANSFERENSIA, transferensia);
  }
  login(correo: String, clave: string): Observable<any>  {
    return this.http.get<Mensaje>(this.WS_LOGEO + "?clave=" + clave +"&correo="+correo);
  }
  cambiarClave(correo: string): Observable<any>  {
    return this.http.get<Mensaje>(this.WS_CAMBIO_CLAVE + "?correo=" + correo);
  }
}
