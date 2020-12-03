import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentationCreateComponent } from './documentation-create';

describe('EditDocumentaitonComponent', () => {
  let component: DocumentationCreateComponent;
  let fixture: ComponentFixture<DocumentationCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentationCreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentationCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
