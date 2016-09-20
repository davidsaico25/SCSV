package modelo;
// Generated Nov 19, 2015 3:42:42 PM by Hibernate Tools 4.3.1



/**
 * DetalleFacturaId generated by hbm2java
 */
public class DetalleFacturaId  implements java.io.Serializable {


     private int codFactura;
     private String numeroSerie;

    public DetalleFacturaId() {
    }

    public DetalleFacturaId(int codFactura, String numeroSerie) {
       this.codFactura = codFactura;
       this.numeroSerie = numeroSerie;
    }
   
    public int getCodFactura() {
        return this.codFactura;
    }
    
    public void setCodFactura(int codFactura) {
        this.codFactura = codFactura;
    }
    public String getNumeroSerie() {
        return this.numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetalleFacturaId) ) return false;
		 DetalleFacturaId castOther = ( DetalleFacturaId ) other; 
         
		 return (this.getCodFactura()==castOther.getCodFactura())
 && ( (this.getNumeroSerie()==castOther.getNumeroSerie()) || ( this.getNumeroSerie()!=null && castOther.getNumeroSerie()!=null && this.getNumeroSerie().equals(castOther.getNumeroSerie()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodFactura();
         result = 37 * result + ( getNumeroSerie() == null ? 0 : this.getNumeroSerie().hashCode() );
         return result;
   }   


}


