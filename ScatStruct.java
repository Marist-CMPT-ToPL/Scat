import java.util.HashMap;
import java.util.Map;

class ScatStruct {
  private final ScatPack pack;
  private final Map<String, Object> fields = new HashMap<>();

  ScatStruct(ScatPack pack) {
    this.pack = pack;
  }

  Object get(Token name) {
    if (fields.containsKey(name.lexeme)) {
      return fields.get(name.lexeme);
    }

    throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
  }

  void set(Token name, Object value) {
    fields.put(name.lexeme, value);
  }

  @Override
  public String toString() {
    return pack.name + " instance";
  }
}