package tachiyomi.data.manga

import eu.kanade.tachiyomi.source.model.UpdateStrategy
import tachiyomi.domain.library.model.LibraryManga
import tachiyomi.domain.manga.model.Manga
import tachiyomi.view.LibraryView

object MangaMapper {
    fun mapManga(
        id: Long,
        source: Long,
        url: String,
        artist: String?,
        author: String?,
        description: String?,
        genre: List<String>?,
        title: String,
        status: Long,
        thumbnailUrl: String?,
        favorite: Boolean,
        lastUpdate: Long?,
        nextUpdate: Long?,
        initialized: Boolean,
        viewerFlags: Long,
        chapterFlags: Long,
        coverLastModified: Long,
        dateAdded: Long,
        // SY -->
        @Suppress("UNUSED_PARAMETER")
        filteredScanlators: String?,
        // SY <--
        updateStrategy: UpdateStrategy,
        calculateInterval: Long,
        lastModifiedAt: Long,
        favoriteModifiedAt: Long?,
    ): Manga = Manga(
        id = id,
        source = source,
        favorite = favorite,
        lastUpdate = lastUpdate ?: 0,
        nextUpdate = nextUpdate ?: 0,
        fetchInterval = calculateInterval.toInt(),
        dateAdded = dateAdded,
        viewerFlags = viewerFlags,
        chapterFlags = chapterFlags,
        coverLastModified = coverLastModified,
        url = url,
        // SY -->
        ogTitle = title,
        ogArtist = artist,
        ogAuthor = author,
        ogThumbnailUrl = thumbnailUrl,
        ogDescription = description,
        ogGenre = genre,
        ogStatus = status,
        // SY <--
        updateStrategy = updateStrategy,
        initialized = initialized,
        lastModifiedAt = lastModifiedAt,
        favoriteModifiedAt = favoriteModifiedAt,
    )

    fun mapLibraryManga(
        id: Long,
        source: Long,
        url: String,
        artist: String?,
        author: String?,
        description: String?,
        genre: List<String>?,
        title: String,
        status: Long,
        thumbnailUrl: String?,
        favorite: Boolean,
        lastUpdate: Long?,
        nextUpdate: Long?,
        initialized: Boolean,
        viewerFlags: Long,
        chapterFlags: Long,
        coverLastModified: Long,
        dateAdded: Long,
        // SY -->
        @Suppress("UNUSED_PARAMETER")
        filteredScanlators: String?,
        // SY <--
        updateStrategy: UpdateStrategy,
        calculateInterval: Long,
        lastModifiedAt: Long,
        favoriteModifiedAt: Long?,
        totalCount: Long,
        readCount: Double,
        latestUpload: Long,
        chapterFetchedAt: Long,
        lastRead: Long,
        bookmarkCount: Double,
        category: Long,
    ): LibraryManga = LibraryManga(
        manga = mapManga(
            id,
            source,
            url,
            artist,
            author,
            description,
            genre,
            title,
            status,
            thumbnailUrl,
            favorite,
            lastUpdate,
            nextUpdate,
            initialized,
            viewerFlags,
            chapterFlags,
            coverLastModified,
            dateAdded,
            // SY -->
            null,
            // SY <--
            updateStrategy,
            calculateInterval,
            lastModifiedAt,
            favoriteModifiedAt,
        ),
        category = category,
        totalChapters = totalCount,
        readCount = readCount.toLong(),
        bookmarkCount = bookmarkCount.toLong(),
        latestUpload = latestUpload,
        chapterFetchedAt = chapterFetchedAt,
        lastRead = lastRead,
    )

    fun mapLibraryView(libraryView: LibraryView): LibraryManga {
        return LibraryManga(
            manga = Manga(
                id = libraryView._id,
                source = libraryView.source,
                favorite = libraryView.favorite,
                lastUpdate = libraryView.last_update ?: 0,
                nextUpdate = libraryView.next_update ?: 0,
                dateAdded = libraryView.date_added,
                viewerFlags = libraryView.viewer,
                chapterFlags = libraryView.chapter_flags,
                coverLastModified = libraryView.cover_last_modified,
                url = libraryView.url,
                ogTitle = libraryView.title,
                ogArtist = libraryView.artist,
                ogAuthor = libraryView.author,
                ogDescription = libraryView.description,
                ogGenre = libraryView.genre,
                ogStatus = libraryView.status,
                ogThumbnailUrl = libraryView.thumbnail_url,
                updateStrategy = libraryView.update_strategy,
                initialized = libraryView.initialized,
                fetchInterval = libraryView.calculate_interval.toInt(),
                lastModifiedAt = libraryView.last_modified_at,
                favoriteModifiedAt = libraryView.favorite_modified_at,
            ),
            category = libraryView.category,
            totalChapters = libraryView.totalCount,
            readCount = libraryView.readCount.toLong(),
            bookmarkCount = libraryView.bookmarkCount.toLong(),
            latestUpload = libraryView.latestUpload,
            chapterFetchedAt = libraryView.chapterFetchedAt,
            lastRead = libraryView.lastRead,
        )
    }
}
