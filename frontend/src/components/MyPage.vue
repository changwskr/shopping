<template>

<v-data-table
    :headers="headers"
    :items="myPage"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyPage',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
            { text: "accountId", value: "accountId" },
            { text: "itemId", value: "itemId" },
            { text: "quantity", value: "quantity" },
            { text: "address", value: "address" },
            { text: "deliveryStatus", value: "deliveryStatus" },
            { text: "orderStatus", value: "orderStatus" },
            { text: "stock", value: "stock" },
        ],
        myPage : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/mypages')

      this.myPage = temp.data._embedded.mypages;

    },
    methods: {
    }
  }
</script>

