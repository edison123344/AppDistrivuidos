import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ConsutarSaldoPageRoutingModule } from './consutar-saldo-routing.module';

import { ConsutarSaldoPage } from './consutar-saldo.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ConsutarSaldoPageRoutingModule
  ],
  declarations: [ConsutarSaldoPage]
})
export class ConsutarSaldoPageModule {}
