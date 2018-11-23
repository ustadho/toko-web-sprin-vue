<template>
    <div>
        <div class="row">
            <div class="col-6">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nama</th>
                        <th scope="col">Harga</th>
                        <th scope="col">Kategori</th>
                        <th> <b-button variant="success">Tambah</b-button></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(i, idx) in items.content" :key="idx">
                            <th scope="row">{{i.id}}</th>
                            <td>{{i.nama}}</td>
                            <td>{{i.harga}}</td>
                            <td>{{i.kategori.nama}}</td>
                            <td>
                                <b-button variant="default" @click="ubah(i)">Ubah</b-button> 
                                <b-button variant="danger" @click="hapus(i)">Hapus</b-button>
                            </td>
                        </tr>
                    </tbody>
                    </table>
            </div>
            <div class="col-6">
                <div class="col">
                    <b-form-group id="fieldsetHorizontal"
                                    horizontal
                                    :label-cols="4"
                                    breakpoint="md"
                                    label="Nama Barang"
                                    label-for="nama">
                        <b-form-input id="nama" v-model="vm.nama"></b-form-input>
                    </b-form-group>
                    <b-form-group id="fieldsetHorizontal"
                                    horizontal
                                    :label-cols="4"
                                    breakpoint="md"
                                    label="Harga Barang"
                                    label-for="harga">
                                    <input type="number" class="form-control" id="harga" placeholder="Masukkan Harga Item"  v-model="vm.harga">
                    </b-form-group>
                    <b-form-group id="fieldsetHorizontal"
                                    horizontal
                                    :label-cols="4"
                                    breakpoint="md"
                                    label="Kategori Barang"
                                    label-for="kategori">
                        <v-select v-model="vm.kategori" label="nama" :options="listKategori"></v-select>
                    </b-form-group>
                    <b-button variant="default" @click="bersihkan">Bersihkan</b-button>
                    <b-button variant="success" @click="simpan">Simpan</b-button>
                </div>
            </div>
        </div>
        <p>
        listKategori: {{listKategori}}
        </p>
    </div>
</template>

<script>
    const axios = require("axios");
    export default {
  data() {
    return {
      items: [],
      vm : {},
      listKategori: [],
      judul: "Ini halaman Item ya"
    };
  },
  methods : {
    bersihkan(){
      this.vm = {}
    },
    ubah(item){
      this.vm = JSON.parse(JSON.stringify(item));
    },
    simpan(){
      if(this.vm.id!=null){
        axios.put("/api/master/item/", this.vm)
        .then(() => (this.refresh()));
      }else{
        axios.post("/api/master/item", this.vm)
        .then(() => (this.refresh()));
      }
    },
    hapus(item){
      axios.delete("/api/master/item/"+item.id)
        .then(() => (this.refresh()));
    },
    refresh(){
      axios.get("/api/master/item").then(response => (this.items = response.data));
    }
  },
  mounted() {
    this.refresh();
    axios.get("/api/master/kategori-item/all").then(response => (this.listKategori = response.data));
  }
};
</script>