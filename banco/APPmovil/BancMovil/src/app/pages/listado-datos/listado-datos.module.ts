import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ListadoDatosPageRoutingModule } from './listado-datos-routing.module';

import { ListadoDatosPage } from './listado-datos.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ListadoDatosPageRoutingModule
  ],
  declarations: [ListadoDatosPage]
})
export class ListadoDatosPageModule {
}
