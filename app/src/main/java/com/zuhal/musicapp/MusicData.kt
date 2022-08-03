package com.zuhal.musicapp
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.util.*
import kotlin.collections.ArrayList

// Registering the Kotlin module with the ObjectMpper instance
val mapper = jacksonObjectMapper()

object MusicData {
    val listData: List<Music>
    get() {
        val list: ArrayList<Music> = mapper.readValue(jsonString, object: TypeReference<ArrayList<Music>>() {})
        return list
    }
}

val jsonString = """
    [
      {
        "track_id": "45918693",
        "title": "Left and Right (Feat. Jung Kook of BTS)",
        "artists": "Charlie Puth, Jung Kook, BTS",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/a7LWBkzbzX/7LWBL4xOKz/size_m_1642653813.webp",
        "album": "Left and Right (Feat. Jung Kook of BTS)",
        "album_id": "6005358",
        "duration": "154",
        "genres": "Pop",
        "language": "English",
        "label": "Atlantic Records",
        "release_date": "2022-06-24",
        "play_count": "1M+",
        "favorite_count": 5497,
        "song_url": "https://gaana.com/song/left-and-right-feat-jung-kook-of-bts",
        "album_url": "https://gaana.com/album/left-and-right-feat-jung-kook-of-bts",
        "images": "https://a10.gaanacdn.com/gn_img/albums/9MAWe97WyJ/AWe9RA8qWy/size_l.jpg"
      },
      {
        "track_id": "46334164",
        "title": "La La Love",
        "artists": "Elnaaz Norouzi",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/g4w3vr3jJB/w3vwBjLAWj/size_m.jpg",
        "album": "La La Love",
        "album_id": "6119773",
        "duration": "156",
        "genres": "Pop",
        "language": "English",
        "label": "Elnaaz Norouzi",
        "release_date": "2022-07-22",
        "play_count": "<100K",
        "favorite_count": 326,
        "song_url": "https://gaana.com/song/la-la-love-60",
        "album_url": "https://gaana.com/album/la-la-love-english-2022",
        "images": "https://a10.gaanacdn.com/gn_img/albums/81l3Mye3rM/l3MyEAyG3r/size_l.jpg"
      },
      {
        "track_id": "46346167",
        "title": "Time Bomb",
        "artists": "The Chainsmokers",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/21GWwrR3pk/1GWwr8av3p/size_m_1516797570.webp",
        "album": "So Far So Good (+ Time Bomb)",
        "album_id": "6123610",
        "duration": "203",
        "genres": "Pop",
        "language": "English",
        "label": "Sony Music",
        "release_date": "2022-07-22",
        "play_count": "<100K",
        "favorite_count": 306,
        "song_url": "https://gaana.com/song/time-bomb-337",
        "album_url": "https://gaana.com/album/so-far-so-good-time-bomb",
        "images": "https://a10.gaanacdn.com/gn_img/albums/DwPKOBbqVZ/PKOxZOgY3q/size_l.jpg"
      },
      {
        "track_id": "45801035",
        "title": "Gimmie The Loot",
        "artists": "DVRST, Jarren Benton",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/0wrb4qNKLg/wrb401vAbL/size_m.jpg",
        "album": "Gimmie The Loot (Remix)",
        "album_id": "5971642",
        "duration": "151",
        "genres": "Electronic",
        "language": "English",
        "label": "DVRST x Jarren Benton",
        "release_date": "2022-07-08",
        "play_count": "100K+",
        "favorite_count": 785,
        "song_url": "https://gaana.com/song/gimmie-the-loot-1",
        "album_url": "https://gaana.com/album/gimmie-the-loot-remix",
        "images": "https://a10.gaanacdn.com/gn_img/albums/6Zxb27K9wN/xb2rJxZob9/size_l.jpg"
      },
      {
        "track_id": "46057305",
        "title": "Hot Shit (feat. Kanye West & Lil Durk)",
        "artists": "Cardi B, Kanye West, Lil Durk",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/XYybzrb2gz/Yybz184PW2/size_m_1631803443.webp",
        "album": "Hot Shit (feat. Kanye West & Lil Durk)",
        "album_id": "6038463",
        "duration": "211",
        "genres": "",
        "language": "English",
        "label": "Atlantic Records",
        "release_date": "2022-06-30",
        "play_count": "100K+",
        "favorite_count": 1565,
        "song_url": "https://gaana.com/song/hot-shit-feat-kanye-west-lil-durk",
        "album_url": "https://gaana.com/album/hot-shit-feat-kanye-west-lil-durk",
        "images": "https://a10.gaanacdn.com/gn_img/albums/Bp1bAynb02/1bAyqgyPb0/size_l.jpg"
      },
      {
        "track_id": "45859949",
        "title": "Drool",
        "artists": "Saurabh Shetye",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/XzVWRyL3dq/zVWRjJLkWd/size_m.jpg",
        "album": "Drool",
        "album_id": "5988435",
        "duration": "152",
        "genres": "Pop",
        "language": "English",
        "label": "Songdew",
        "release_date": "2022-07-07",
        "play_count": "<100K",
        "favorite_count": 405,
        "song_url": "https://gaana.com/song/drool-20",
        "album_url": "https://gaana.com/album/drool-english-2022",
        "images": "https://a10.gaanacdn.com/gn_img/albums/jBr3gybR1m/r3gLrgjyWR/size_l.jpg"
      },
      {
        "track_id": "45992602",
        "title": "Bad Habit",
        "artists": "Steve Lacy",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/jBr3gLyWR1/Br3gNoOKR1/size_m.jpg",
        "album": "Bad Habit",
        "album_id": "6025052",
        "duration": "232",
        "genres": "R&B/Soul",
        "language": "English",
        "label": "Sony Music",
        "release_date": "2022-06-29",
        "play_count": "<100K",
        "favorite_count": 223,
        "song_url": "https://gaana.com/song/bad-habit-212",
        "album_url": "https://gaana.com/album/bad-habit-english-2022-6",
        "images": "https://a10.gaanacdn.com/gn_img/albums/0wrb4qNKLg/rb4qDV6MKL/size_l.jpg"
      },
      {
        "track_id": "45456137",
        "title": "The Drop",
        "artists": "Dimitri Vegas & Like Mike, David Guetta, Nicole Scherzinger, Azteck",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/g4w3vr3jJB/4w3vwZaAWj/size_m_1550126609.webp",
        "album": "The Drop",
        "album_id": "5881659",
        "duration": "121",
        "genres": "Electronic",
        "language": "English",
        "label": "House Of House",
        "release_date": "2022-06-24",
        "play_count": "<100K",
        "favorite_count": 748,
        "song_url": "https://gaana.com/song/the-drop-206",
        "album_url": "https://gaana.com/album/the-drop-english-2022",
        "images": "https://a10.gaanacdn.com/gn_img/albums/mGjKrP1W6z/jKrPYrrjW6/size_l.jpg"
      },
      {
        "track_id": "45667865",
        "title": "hope",
        "artists": "Xxxtentacion",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/BZgWoOW2d9/ZgWooMqrW2/size_m_1629968943.webp",
        "album": "LOOK AT ME: THE ALBUM",
        "album_id": "5933083",
        "duration": "110",
        "genres": "Rap",
        "language": "English",
        "label": "Sony Music",
        "release_date": "2022-06-10",
        "play_count": "1M+",
        "favorite_count": 9976,
        "song_url": "https://gaana.com/song/hope-2737",
        "album_url": "https://gaana.com/album/look-at-me-the-album",
        "images": "https://a10.gaanacdn.com/gn_img/albums/YoEWlwa3zX/EWlwLE5y3z/size_l.jpg"
      },
      {
        "track_id": "45512397",
        "title": "Somebody Like U",
        "artists": "Alan Walker, Au/Ra",
        "artist_image": "https://a10.gaanacdn.com/gn_img/artists/DwPKOkBKqV/wPKO8PDY3q/size_m_1648045247.webp",
        "album": "Walkerverse, Pt. I",
        "album_id": "5897681",
        "duration": "191",
        "genres": "Pop",
        "language": "English",
        "label": "Sony Music",
        "release_date": "2022-06-17",
        "play_count": "500K+",
        "favorite_count": 2778,
        "song_url": "https://gaana.com/song/somebody-like-u-5",
        "album_url": "https://gaana.com/album/walkerverse-pt-i",
        "images": "https://a10.gaanacdn.com/gn_img/albums/z8k3yd1Krx/k3yd0XqnKr/size_l.jpg"
      }
    ]
""".trimIndent()