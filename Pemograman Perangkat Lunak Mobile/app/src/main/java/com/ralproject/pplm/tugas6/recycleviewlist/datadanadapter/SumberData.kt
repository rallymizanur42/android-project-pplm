package com.ralproject.pplm.tugas6.recycleviewlist.datadanadapter

class SumberData {
    companion object {
        fun buatSetData(): ArrayList<ListObjDosen> {
            val list = ArrayList<ListObjDosen>()

            list.add(
                ListObjDosen(
                    "Ananda, S.Kom.,M.T.",
                    "Digital Image Processing",
                    "https://pcr.ac.id/assets/images/pegawai/AND20240906033830.jpg",
                    "108501",
                    "Digital Image Processing, Object Oriented Programming,",
                    "Lab. Komputer 301"
                )
            )

            list.add(
                ListObjDosen(
                    "Silvana Rasio Henim, S.ST., M.T.",
                    "Programming",
                    "https://pcr.ac.id/assets/images/pegawai/SRH20190718105457.jpg",
                    "199007182022032002",
                    "Pemrograman Mobile",
                    "Ruang 302"
                )
            )

            list.add(
                ListObjDosen(
                    "Agus Urip Ari Wibowo, S.T., M.T.",
                    "IoT",
                    "https://pcr.ac.id/assets/images/pegawai/AUA20190718114257.jpg",
                    "198907182022031003",
                    "Internet of Things",
                    "Lab. IoT 303"
                )
            )

            list.add(
                ListObjDosen(
                    "Ardianto Wibowo, S.Kom.,M.T.",
                    "Data Engineering",
                    "https://pcr.ac.id/assets/images/pegawai/ARW20190718113926.jpg",
                    "198807182022031004",
                    "Rekayasa Data",
                    "Ruang 304"
                )
            )

            list.add(
                ListObjDosen(
                    "Erwin Setyo Nugroho, S.T., M.Bsn.",
                    "Computer Networking & Administration",
                    "https://pcr.ac.id/assets/images/pegawai/ESN20190718113952.jpg",
                    "198807182022031005",
                    "Jaringan Komputer",
                    "Lab. Jaringan 305"
                )
            )

            list.add(
                ListObjDosen(
                    "Binu Surya, S.T., M.T.",
                    "Operating System",
                    "https://pcr.ac.id/assets/images/pegawai/ISA20190718114016.jpg",
                    "198807182022031006",
                    "Sistem Operasi",
                    "Ruang 306"
                )
            )

            return list
            }
        }
}