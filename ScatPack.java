import java.util.List;

class ScatPack implements Callable {
  final String name;
  private final List<String> fields;

  ScatPack(String name, List<String> fields) {
    this.name = name;
    this.fields = fields;
  }

  @Override
  public int arity() {
    return fields.size();
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    ScatStruct instance = new ScatStruct(this);
    
    for (int i = 0; i < fields.size(); i++) {
      instance.set(new Token(TokenType.IDENTIFIER, fields.get(i), null, 0), arguments.get(i));
    }
    
    return instance;
  }

  @Override
  public String toString() {
    return "<pack " + name + ">";
  }
}