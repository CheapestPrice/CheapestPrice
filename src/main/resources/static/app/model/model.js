
Tienda.prototype.agregarHorario = function(horario){
    this.horarios.push(horario);
}

Tienda.prototype.agregarItem = function(item){
    this.items.push(item);
}

Tienda.prototype.agregarOpinion = function(opinion){
    this.opiniones.push(opinion);
}
function Producto(id, nombre, marca, categoria){
    this.id = id;
    this.nombre = nombre;
    this.marca = marca;
    this.categoria = categoria
}

function Tendero(correo, nombre){
    this.correo = correo;
    this.nombre = nombre;
}

function TiendaId(nit, x, y){
    this.nit = nit;
    this.x = x;
    this.y = y;
}

function Tienda(id, direccion, nombre, telefono, disponible, tendero){
    this.id = id;
    this.direccion = direccion;
    this.nombre = nombre;
    this.telefono = telefono;
    this.disponible = disponible;
    this.tendero = tendero;
    this.horarios = [];
    this.opiniones = [];
    this.items = [];
}

function ItemId(productoId, tiendaX, tiendaY, tiendaNit){
    this.productoId = productoId;
    this.tiendaX = tiendaX;
    this.tiendaY = tiendaY;
    this.tiendaNit = tiendaNit;
}

function Item(id, tienda, producto, precio){
    this.id = id;
    this.tienda = tienda;
    this.producto = producto;
    this.precio = precio;
}

function ItemListaId(tiendaNit, tiendaX, tiendaY, productoId, listaNombre, listaCorreo){
    this.tiendaNit = tiendaNit;
    this.tiendaX = tiendaX;
    this.tiendaY = tiendaY;
    this.productoId = productoId;
    this.listaNombre = listaNombre;
    this.listaCorreo = listaCorreo;
}

function ItemLista(id, comprado, favorito, item, lista){
    this.id=id;
    this.comprado = comprado;
    this.favorito = favorito;
    this.item = item;
    this.lista = lista;
}

function ListaMercado_Item(nombre, usuario){
    this.nombre = nombre;
    this.usuario = usuario;
}

function ListaDeMercado(listaid, fechaCreacion, revisado, usuario){
    this.listaid = listaid;
    this.fechaCreacion = fechaCreacion;
    this.revisado = revisado;
    this.usuario = usuario;
    this.items = [];
}