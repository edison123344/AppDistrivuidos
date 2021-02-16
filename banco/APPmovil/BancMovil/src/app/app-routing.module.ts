import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'folder/Inbox',
    pathMatch: 'full'
  },
  {
    path: 'folder/:id',
    loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  },
  {
    path: 'consutar-saldo',
    loadChildren: () => import('./consutar-saldo/consutar-saldo.module').then( m => m.ConsutarSaldoPageModule)
  },
  {
    path: 'listado-datos',
    loadChildren: () => import('./pages/listado-datos/listado-datos.module').then( m => m.ListadoDatosPageModule)
  },
  {
    path: 'trasnferencia',
    loadChildren: () => import('./pages/trasnferencia/trasnferencia.module').then( m => m.TrasnferenciaPageModule)
  },
  {
    path: 'cambio-clave',
    loadChildren: () => import('./pages/cambio-clave/cambio-clave.module').then( m => m.CambioClavePageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
