package agenda;

public class Contato {
    private int posicao;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String[] tags;

    public Contato(int posicao, String nome, String sobrenome, String telefone){
        this.posicao = posicao;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.tags = new String[5];
    }
    
    public String getNome(){
        return this.nome+" "+this.sobrenome;
    }
    public String getDados(){
        return this.getNome()+"\n"+this.telefone+"\n"+toStringTags();
    }
    public void setTags(int posicao, String tag){
        this.tags[posicao] = tag;
    }
    public String toStringTags(){
        String retorno = "";
        for (int i=0; i<this.tags.length; i++){
            if(this.tags[i] != null){
                retorno = retorno+this.tags[i]+" ";
            }
        }
        return retorno;
    }
    public String toString(){
        return posicao+" - "+this.getNome();
    }
    
}
