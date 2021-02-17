import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../model/Usuario';
import { DepositarService } from '../../services/depositar.service';

@Component({
  selector: 'app-cambio-clave',
  templateUrl: './cambio-clave.page.html',
  styleUrls: ['./cambio-clave.page.scss'],
})
export class CambioClavePage implements OnInit {
  usuario: Usuario = new Usuario();
  constructor(public dtService: DepositarService) { }

  ngOnInit() {
  }
  cambiarClave() {
    console.log(this.usuario.mail);
    this.dtService.cambiarClave(this.usuario.mail).subscribe(data => {
      console.log(data);
    });
  }
}
