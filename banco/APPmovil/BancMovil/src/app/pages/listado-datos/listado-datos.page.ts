import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { DepositarService } from '../../services/depositar.service';

@Component({
  selector: 'app-listado-datos',
  templateUrl: './listado-datos.page.html',
  styleUrls: ['./listado-datos.page.scss'],
})
export class ListadoDatosPage implements OnInit {
  public Estado: Observable<any>
  public Poliza: Observable<any>
  constructor(public dtService: DepositarService ) { }

  ngOnInit() {
    this.Estado = this.dtService.listarcuenta();
    this.Poliza = this.dtService.listarPoliza();
  }

}
