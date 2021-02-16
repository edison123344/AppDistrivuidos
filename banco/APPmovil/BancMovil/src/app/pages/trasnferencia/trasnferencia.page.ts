import { Component, OnInit } from '@angular/core';
import { Transferencia } from '../../model/Transferencia';
import { DepositarService } from '../../services/depositar.service';

@Component({
  selector: 'app-trasnferencia',
  templateUrl: './trasnferencia.page.html',
  styleUrls: ['./trasnferencia.page.scss'],
})
export class TrasnferenciaPage implements OnInit {
  transferencia: Transferencia= new Transferencia();
  constructor(public tfServise:DepositarService) { }

  ngOnInit() {
  }
  guardar() {
    console.log(this.transferencia);
    this.tfServise.trasferencia(this.transferencia).subscribe(data => {
      console.log(data);
    });
  }
}
