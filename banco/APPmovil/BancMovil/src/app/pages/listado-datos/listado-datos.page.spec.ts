import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ListadoDatosPage } from './listado-datos.page';

describe('ListadoDatosPage', () => {
  let component: ListadoDatosPage;
  let fixture: ComponentFixture<ListadoDatosPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListadoDatosPage ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ListadoDatosPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
