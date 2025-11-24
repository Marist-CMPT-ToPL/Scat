import java.util.ArrayList;
import java.util.List;

class ScatArray {
  private final List<Object> elements;
  public final int length;

  ScatArray(List<Object> elements) {
    this.elements = new ArrayList<>(elements);
    this.length = elements.size();
  }

  Object get(int index) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("Array index out of bounds: " + index);
    }
    return elements.get(index);
  }

  void set(int index, Object value) {
    if (index < 0 || index >= length) {
      throw new RuntimeException("Array index out of bounds: " + index);
    }
    elements.set(index, value);
  }

  ScatArray combine(ScatArray other) {
    List<Object> combined = new ArrayList<>(this.elements);
    combined.addAll(other.elements);
    return new ScatArray(combined);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < elements.size(); i++) {
      if (i > 0) sb.append(", ");
      Object elem = elements.get(i);
      if (elem instanceof String) {
        sb.append("\"").append(elem).append("\"");
      } else if (elem == null) {
        sb.append("zip");
      } else {
        sb.append(stringify(elem));
      }
    }
    sb.append("]");
    return sb.toString();
  }

  private String stringify(Object object) {
    if (object == null) return "zip";

    if (object instanceof Double) {
      String text = object.toString();
      if (text.endsWith(".0")) {
        text = text.substring(0, text.length() - 2);
      }
      return text;
    }

    return object.toString();
  }
}