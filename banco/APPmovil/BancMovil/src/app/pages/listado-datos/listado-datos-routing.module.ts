import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListadoDatosPage } from './listado-datos.page';

const routes: Routes = [
  {
    path: '',
    component: ListadoDatosPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ListadoDatosPageRoutingModule {}
