import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { TrasnferenciaPageRoutingModule } from './trasnferencia-routing.module';

import { TrasnferenciaPage } from './trasnferencia.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    TrasnferenciaPageRoutingModule
  ],
  declarations: [TrasnferenciaPage]
})
export class TrasnferenciaPageModule {}
